package com.waterissue.sayangair.presentation.reward

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.waterissue.sayangair.presentation.reward.component.RewardItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RewardViewModel @Inject constructor() : ViewModel() {
    private val _userPoints = mutableStateOf(50)
    val userPoints: State<Int> get() = _userPoints

    private val _rewards = mutableStateListOf(
        RewardItem.First,
        RewardItem.Second,
        RewardItem.Third,
        RewardItem.Fourth
    )
    val rewards: List<RewardItem> get() = _rewards

    private val _claimResult = mutableStateOf<ClaimResult?>(null)
    val claimResult: State<ClaimResult?> get() = _claimResult

    fun clearClaimResult() {
        _claimResult.value = null
    }

    fun claimVoucher(voucher: RewardItem) {
        if (_userPoints.value >= voucher.pointsRequired) {
            _userPoints.value = _userPoints.value - voucher.pointsRequired
            _claimResult.value = ClaimResult.Success(voucher.title)
        } else {
            _claimResult.value = ClaimResult.Failure("Poin tidak cukup untuk klaim voucher ini.")
        }
    }


    sealed class ClaimResult {
        data class Success(val voucherTitle: String) : ClaimResult()
        data class Failure(val message: String) : ClaimResult()
    }
}
