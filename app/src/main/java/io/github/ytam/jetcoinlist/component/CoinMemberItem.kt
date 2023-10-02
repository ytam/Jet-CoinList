package io.github.ytam.jetcoinlist.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ytam.coinlist.R
import io.github.ytam.jetcoinlist.data.remote.response.TeamMemberResponse

@Composable
fun CoinMemberList(
    teamMemberResponse: TeamMemberResponse
) {
    Card(
        backgroundColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier
            .size(width = 150.dp, height = 200.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(12.dp)

    ) {
        Column(
            modifier = Modifier
                .size(width = 150.dp, height = 200.dp)
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painterResource(R.drawable.ic_baseline_assignment),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
            )

            Text(
                text = teamMemberResponse.name,
                style = MaterialTheme.typography.subtitle2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(12.dp)

            )
            Text(
                text = teamMemberResponse.position,
                style = MaterialTheme.typography.subtitle1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(12.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCoinMemberList() {
    CoinMemberList(
        TeamMemberResponse(
            "",
            "test",
            "testtesttest"
        )
    )
}
