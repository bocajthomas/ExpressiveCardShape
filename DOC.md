<!--TODO: Refactor into a docs website-->
# Installation
```
// build.gradle.kts
dependencies {
    implementation("uk.co.bocajsolutions:cardshape:<version>")
}
```
# Usage
The library provides a composable Shape function that determines the correct RoundedCornerShape for a card based on its position within a group (like a LazyColumn).

## Grouped Cards (e.g., in a List)
To create a visually continuous stack of cards, you calculate the shape for each item by passing the total size of the list and the current item's index.
```kotlin
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.bocajsolutions.cardshape.Shape // Import the custom shape function

@Composable
fun groupedCardList() {
    val items = (1..20).toList() // A list of 20 items
    val groupSize = items.size

    LazyColumn(
        // Use a small gap (e.g., 3.dp which is recommented) to visually connect the cards
        verticalArrangement = Arrangement.spacedBy(3.dp), 
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        itemsIndexed(items) { index, item ->
            // Calculate the shape based on its position
            val groupedShape = Shape(
                groupSize = groupSize,
                index = index
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = groupedShape // Apply the calculated shape
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text("List Item $item")
                }
            }
        }
    }
}
```

## Single Card Usage
If groupSize is set to 1 (or if you only pass one item), the Shape function simply returns a standard RoundedCornerShape with the topRadius of the selected ShapeStyle.
```kotlin
import androidx.compose.material3.Card
import uk.co.bocajsolutions.cardshape.Shape
import uk.co.bocajsolutions.cardshape.ShapeStyle

@Composable
fun SingleCardExample() {
  Card(
    // A group size of 1 always results in a fully rounded card
    shape = Shape(groupSize = 1, index = 0, style = ShapeStyle.ExtraLarge)
  ) {
     // Content
  }
}
```

## Shape Styles
The ShapeStyle object provides predefined topRadius (for the corners of the top/bottom cards) and bottomRadius (for the connecting corners of middle cards) values, controlling the overall visual emphasis of the grouping.

| Style         | topRadius (Outer Corners) | bottomRadius (Connecting Corners) | Description                                                                                            |
|---------------|---------------------------|-----------------------------------|--------------------------------------------------------------------------------------------------------|
| `None`        | `0.dp`                    | `0.dp`                            | Creates perfectly sharp, rectangular corners. The grouped cards form a single, seamless block.         |
| `ExtraSmall`  | `2.dp`                    | `1.dp`                            | Subtle rounding, giving a very slight softness to the group.                                           |
| `Small`       | `4.dp`                    | `2.dp`                            | A moderate, standard level of rounding, commonly used in Android design.                               |
| `Medium`      | `15.dp`                   | `5.dp`                            | The default style. Pronounced rounding on the outer edges and gentle rounding on the connecting edges. |
| `Large`       | `24.dp`                   | `8.dp`                            | Significant, expressive rounding, creating a softer, bubble-like appearance for the group.             |
| `ExtraLarge`  | `48.dp`                   | `16.dp`                           | Maximum rounding, resulting in very distinct, pill-shaped ends for the card group.                     |
 
> [!NOTE]
> For a custom shape use `ShapeStyle.Custom(customTopRadius: Dp, customBottomRadius: Dp)`.
  
### Example using ShapeStyle.ExtraSmall
This example demonstrates how to use ShapeStyle.ExtraSmall to achieve a minimal rounding effect in the grouped list.
```kotlin
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import uk.co.bocajsolutions.cardshape.Shape
import uk.co.bocajsolutions.cardshape.ShapeStyle // Make sure this is imported

@Composable
fun MinimalGroupedCardList(items: List<Any>) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            // Pass the desired style to the Shape function
            val groupedShape = Shape(
                groupSize = items.size,
                index = index,
                style = ShapeStyle.ExtraSmall // <-- Using the ExtraSmall style
            )

            Card(
                shape = groupedShape
            ) {
                // ... Card Content
            }
        }
    }
}
```