package uk.co.bocajsolutions.expressivecardshape.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.bocajsolutions.cardshape.Shape
import uk.co.bocajsolutions.cardshape.ShapeStyle

@Composable
fun MainScreen(paddingValues: PaddingValues) {
    val list = 5
    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        item {
            Text(
                "Demonstration of Elevated Cards with no defined shape defaults to shape ShapeStyle.Medium",
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
        items(list) { index ->
            ElevatedCard(
                modifier = Modifier.fillMaxSize(),
                shape = Shape(list, index)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(15.dp)
                ){
                    Text("Item $index")
                }
            }
        }
        item {
            Text(
                "Demonstration of Elevated Cards with a defined shape of ShapeStyle.None",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(list) { index ->
            ElevatedCard(
                modifier = Modifier.fillMaxSize(),
                shape = Shape(list, index, style = ShapeStyle.None)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(15.dp)
                ){
                    Text("Item $index")
                }
            }
        }
        item {
            Text(
                "Demonstration of Elevated Cards with a defined shape of ShapeStyle.ExtraSmall",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(list) { index ->
            ElevatedCard(
                modifier = Modifier.fillMaxSize(),
                shape = Shape(list, index,style = ShapeStyle.ExtraSmall)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(15.dp)
                ){
                    Text("Item $index")
                }
            }
        }
        item {
            Text(
                "Demonstration of Elevated Cards with a defined shape of ShapeStyle.Small",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(list) { index ->
            ElevatedCard(
                modifier = Modifier.fillMaxSize(),
                shape = Shape(list, index, style = ShapeStyle.Small)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(15.dp)
                ){
                    Text("Item $index")
                }
            }
        }
        item {
            Text(
                "Demonstration of Elevated Cards with a defined shape of ShapeStyle.Medium",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(list) { index ->
            ElevatedCard(
                modifier = Modifier.fillMaxSize(),
                shape = Shape(list, index, style = ShapeStyle.Medium)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(15.dp)
                ){
                    Text("Item $index")
                }
            }
        }
        item {
            Text(
                "Demonstration of Elevated Cards with a defined shape of ShapeStyle.Large",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(list) { index ->
            ElevatedCard(
                modifier = Modifier.fillMaxSize(),
                shape = Shape(list, index, style = ShapeStyle.Large)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(15.dp)
                ){
                    Text("Item $index")
                }
            }
        }
        item {
            Text(
                "Demonstration of Elevated Cards with a defined shape of ShapeStyle.ExtraLarge",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(list) { index ->
            ElevatedCard(
                modifier = Modifier.fillMaxSize(),
                shape = Shape(list, index, style = ShapeStyle.ExtraLarge)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(15.dp)
                ){
                    Text("Item $index")
                }
            }
        }
        item {
            Text(
                "Demonstration of Elevated Cards with a defined shape of ShapeStyle.Custom(12.dp, 2.dp)",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(list) { index ->
            ElevatedCard(
                modifier = Modifier.fillMaxSize(),
                shape = Shape(list, index, style = ShapeStyle.Custom(12.dp, 2.dp))
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(15.dp)
                ){
                    Text("Item $index")
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}