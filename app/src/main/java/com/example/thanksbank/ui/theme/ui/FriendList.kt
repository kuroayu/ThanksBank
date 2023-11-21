package com.example.thanksbank.ui.theme.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thanksbank.ui.theme.ThanksBankApplication
import com.example.thanksbank.ui.theme.model.FriendUiState
import com.example.thanksbank.ui.theme.theme.ThanksBankTheme
import kotlin.math.min


@Composable
fun FriendListContent(toThanksList: (Int?) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        val friendListViewModel = viewModel() {
            val application =
                get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY) as ThanksBankApplication
            FriendListViewModel(application.friendRepository)
        }
        friendListViewModel.init()
        FriendList(friendListViewModel, onItemClick = { friendId ->
            toThanksList(friendId)
        }
        )
    }
}

@Composable
fun FriendList(
    friendListViewModel: FriendListViewModel,
    onItemClick: (Int) -> Unit
) {
    val friendData by friendListViewModel.allFriendData.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(friendData) { data ->
                FriendListItem(
                    friendData = data
                ) {
                    onItemClick(data.id)
                }
            }
        }
    )
}

@Composable
fun FriendListItem(friendData: FriendUiState, onItemClick: () -> Unit) {

    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary, shape = RoundedCornerShape(8.dp))
            .padding(5.dp)
            .clickable(onClick = onItemClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = friendData.friendName,
                color = MaterialTheme.colors.onSecondary
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            CircleProgress(friendData.totalThanksPoint, Modifier.size(120.dp))
        }
    }
}


@Composable
fun CircleProgress(
    progress: Int,         // 進捗状況を示す整数値（0から100の範囲）
    modifier: Modifier,    // 外観や配置を調整する修飾子
    colorProgress: Color = MaterialTheme.colors.primary, // 進捗バーの色（デフォルトはプライマリカラー）
    colorBackground: Color = Color.Gray.copy(alpha = 0.2f), // 進捗バーの背景色（デフォルトは指定のカラー）
    strokeWidth: Dp = 8.dp // 進捗バーの線の太さ（デフォルトは8dp）
) {

    Canvas(modifier = modifier) {  // Canvasを使用してグラフィカル要素を描画
        val stroke = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round) // 線の太さとスタイルを設定
        val diameter = min(size.width, size.height) - stroke.width // 円の直径を計算
        val topLeft = Offset((size.width - diameter) / 2, (size.height - diameter) / 2) // 円の位置を計算
        val circleSize = Size(diameter, diameter) // 円のサイズを設定

        // 背景用の円を描画
        drawArc(
            color = colorBackground,  // 背景の色
            startAngle = -90f,        // 開始角度
            sweepAngle = 360f,        // 円を360度描画（全円）
            useCenter = false,        // 円弧の中央部分を埋めない
            style = stroke,           // ストロークの設定
            topLeft = topLeft,        // 円の位置
            size = circleSize         // 円のサイズ
        )

        // 進捗用の円を描画
        drawArc(
            color = colorProgress,    // 進捗バーの色
            startAngle = -90f,        // 開始角度
            sweepAngle = 360f / 100 * progress, // 進捗に応じた角度を描画
            useCenter = false,        // 円弧の中央部分を埋めない
            style = stroke,           // ストロークの設定
            topLeft = topLeft,        // 円の位置
            size = circleSize         // 円のサイズ
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewFriendList() {
    ThanksBankTheme {
        FriendListContent {
        }
    }
}