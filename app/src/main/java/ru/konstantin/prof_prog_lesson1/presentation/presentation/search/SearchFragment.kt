package ru.konstantin.prof_prog_lesson1.presentation.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.translators.R
import com.example.translators.databinding.FragmentSearchBinding
import ru.konstantin.prof_prog_lesson1.presentation.data.api.TranslatorAPI
import ru.konstantin.prof_prog_lesson1.presentation.data.mappers.DataModelMapper
import ru.konstantin.prof_prog_lesson1.presentation.data.repository.RepositoryImpl
import ru.konstantin.prof_prog_lesson1.presentation.presentation.adapter.SearchAdapter
import ru.konstantin.prof_prog_lesson1.presentation.presentation.clearFocus
import ru.konstantin.prof_prog_lesson1.presentation.presentation.hideKeyboard
import ru.konstantin.prof_prog_lesson1.presentation.util.SchedulersProviderImplementation
import com.google.android.material.snackbar.Snackbar

class SearchFragment : Fragment(R.layout.fragment_search), SearchContract.View {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: SearchPresenter

    private lateinit var adapter: SearchAdapter

    private lateinit var searchButtonClickListener: View.OnClickListener

    private lateinit var errorSnackbar: Snackbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        initPresenter()
        initRecycler()
        initSearchListener()
        initErrorSnackbar()
    }

    private fun initPresenter() {
        presenter = SearchPresenter(
            RepositoryImpl(TranslatorAPI.create(), DataModelMapper()),
            SchedulersProviderImplementation()
        )
        presenter.attachView(this)
    }

    private fun initRecycler() {
        adapter = SearchAdapter(emptyList())
        binding.resultRecycler.adapter = adapter
        binding.resultRecycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun initSearchListener() {
        searchButtonClickListener = View.OnClickListener {
            //So far isOnline is always true
            presenter.getData(binding.searchEditText.text.toString(), true)
            hideErrorSnackbar()
            cancelInput()
        }

        binding.searchInputLayout.setEndIconOnClickListener(searchButtonClickListener)
        binding.searchEditText.setOnEditorActionListener { view, _, _ ->
            searchButtonClickListener.onClick(view)
            true
        }
    }

    override fun renderData(viewState: SearchViewState) {
        hideAllViews()

        when (viewState) {
            is SearchViewState.Loading -> binding.loadingFrame.isVisible = true
            is SearchViewState.CallToAction -> binding.callToActionFrame.isVisible = true
            is SearchViewState.EmptyResult -> binding.emptyResultFrame.isVisible = true
            is SearchViewState.Success -> {
                adapter.setData(viewState.data)
                binding.resultRecycler.isVisible = true
            }
            is SearchViewState.Error -> {
                showErrorSnackbar()
                binding.errorFrame.isVisible = true
            }
        }
    }

    private fun hideAllViews() {
        binding.callToActionFrame.isVisible = false
        binding.emptyResultFrame.isVisible = false
        binding.resultRecycler.isVisible = false
        binding.errorFrame.isVisible = false
        binding.loadingFrame.isVisible = false
    }

    private fun initErrorSnackbar() {
        errorSnackbar = Snackbar.make(
            binding.root,
            getString(R.string.search_error_text),
            Snackbar.LENGTH_INDEFINITE
        )
            .setAction(
                getString(R.string.search_try_again),
                searchButtonClickListener
            )
    }

    private fun showErrorSnackbar() =
        errorSnackbar.show()


    private fun hideErrorSnackbar() =
        errorSnackbar.dismiss()

    private fun cancelInput() {
        hideKeyboard()
        clearFocus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.detachView()
    }
}