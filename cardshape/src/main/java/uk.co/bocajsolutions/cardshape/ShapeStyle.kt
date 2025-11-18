package uk.co.bocajsolutions.cardshape

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


sealed class ShapeStyle(
    val topRadius: Dp,
    val bottomRadius: Dp
) {
    data object None : ShapeStyle(topRadius = 0.dp, bottomRadius = 0.dp)
    data object ExtraSmall : ShapeStyle(topRadius = 2.dp, bottomRadius = 1.dp)
    data object Small : ShapeStyle(topRadius = 4.dp, bottomRadius = 2.dp)
    data object Medium : ShapeStyle(topRadius = 15.dp, bottomRadius = 5.dp)
    data object Large : ShapeStyle(topRadius = 24.dp, bottomRadius = 8.dp)
    data object ExtraLarge : ShapeStyle(topRadius = 48.dp, bottomRadius = 16.dp)

    data class Custom(
        val customTopRadius: Dp,
        val customBottomRadius: Dp
    ) : ShapeStyle(topRadius = customTopRadius, bottomRadius = customBottomRadius)
}
