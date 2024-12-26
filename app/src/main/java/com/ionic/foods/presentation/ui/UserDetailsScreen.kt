package com.ionic.foods.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ionic.foods.domain.model.User

@Composable
fun UserDetailsScreen(users: List<User>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(users.size) { index ->
            val user = users[index]
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    Box(
        Modifier.border(3.dp, androidx.compose.ui.graphics.Color.Cyan, androidx.compose.foundation.shape.RoundedCornerShape(5.dp))
        .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(user.image),
                contentDescription = "user img",
                modifier = Modifier
                    .height(55.dp)
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column (
                modifier = Modifier.fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = user.firstName,
                    color = androidx.compose.ui.graphics.Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = user.lastName,
                    color = androidx.compose.ui.graphics.Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = user.email,
                    color = androidx.compose.ui.graphics.Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp),
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}