package io.github.ytam.jetcoinlist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.github.ytam.jetcoinlist.domain.model.CoinItem

@Composable
fun CoinListItem(
    coin: CoinItem,
    onItemClick: (CoinItem) -> Unit
) {

    Card(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable { onItemClick(coin) }
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(coin) }
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = coin.symbol,
                    modifier = Modifier
                        .clip(CircleShape),
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = coin.name,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxHeight()
            )
            Icon(Icons.Filled.KeyboardArrowRight, "")
        }
    }
}
