package uk.co.bocajsolutions.cardshape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape

fun Shape(
    groupSize: Int,
    index: Int,
    style: ShapeStyle = ShapeStyle.Medium
): Shape {
    require(groupSize >= 1) { "groupSize must be 1 or greater." }
    require(index in 0 until groupSize) { "index must be within the group bounds [0, $groupSize)." }

    val large = style.topRadius
    val small = style.bottomRadius
    val cardShapeSingle: Shape = RoundedCornerShape(large)

    val cardShapeGroupedTop: Shape = RoundedCornerShape(
        topStart = large,
        topEnd = large,
        bottomEnd = small,
        bottomStart = small
    )

    val cardShapeGroupedMiddle: Shape = RoundedCornerShape(small)

    val cardShapeGroupedBottom: Shape = RoundedCornerShape(
        topStart = small,
        topEnd = small,
        bottomEnd = large,
        bottomStart = large
    )

    return when (groupSize) {
        1 -> cardShapeSingle
        else -> {
            when (index) {
                0 -> cardShapeGroupedTop
                groupSize - 1 -> cardShapeGroupedBottom
                else -> cardShapeGroupedMiddle
            }
        }
    }
}
