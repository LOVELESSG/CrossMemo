package com.example.crossmemo.ui.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crossmemo.data.memo.Memo
import com.example.crossmemo.data.repository.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val memoRepository: MemoRepository
) : ViewModel() {

    // Expose a StateFlow of the list of memos
    val memos: StateFlow<List<Memo>> = memoRepository.getAllMemos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000), // Keep subscribed for 5s after the last collector stops
            initialValue = emptyList() // Initial value while the actual data is loading
        )
}
