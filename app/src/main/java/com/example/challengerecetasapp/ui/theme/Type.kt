package com.example.challengerecetasapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.challengerecetasapp.R

val Nunito_Sans = FontFamily(
    Font(R.font.nunito_sans_light, FontWeight.Light),
    Font(R.font.nunito_sans, FontWeight.Normal),
    Font(R.font.nunito_sans_medium, FontWeight.Medium),
    Font(R.font.nunito_sans_semibold, FontWeight.SemiBold),
    Font(R.font.nunito_sans_bold, FontWeight.Bold),
    Font(R.font.nunito_sans_black, FontWeight.Black)
)

val Title4xLargeDefaultTextStyle = TextStyle(
    fontFamily = Nunito_Sans,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp,
    lineHeight = 36.sp,
    letterSpacing = 0.sp
)

//ride_sys_text_title_large_default
val TitleLargeDefaultTextStyle = TextStyle(
    fontFamily = Nunito_Sans,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.2.sp
)

//ride_sys_text_paragraph_small_default
val ParagraphSmallTextDefaultStyle = TextStyle(
    fontFamily = Nunito_Sans,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.01.sp
)

//ride_sys_text_paragraph_medium_default
val ParagraphMediumDefaultTextStyle = TextStyle(
    fontFamily = Nunito_Sans,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.02.sp
)

//ride_sys_text_paragraph_large_regular
val ParagraphLargeRegularTextStyle = TextStyle(
    fontFamily = Nunito_Sans,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.02.sp
)

//ride-sys-text-label-large-semibold
val LabelLargeSemiBoldTextStyle = TextStyle(
    fontFamily = Nunito_Sans,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.2.sp
)

//ride-sys-text-label-medium-default
val LabelMediumDefaultBoldTextStyle = TextStyle(
    fontFamily = Nunito_Sans,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.4.sp
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Black,
        fontSize = 32.sp,
        lineHeight = 56.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Black,
        fontSize = 20.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.2.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.2.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.2.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.01.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.02.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.02.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.2.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Nunito_Sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    )
)