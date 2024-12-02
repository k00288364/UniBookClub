package com.example.unibookclub2.components

import androidx.compose.ui.graphics.vector.ImageVector
/**
 * Wraps two ImageVectors and a label needed for those menu items etc
 * that either use a filled icon or outline icon depending on whether
 * the item is selected or not.
 */
data class IconGroup (
    val filledIcon: ImageVector,
    val outlineIcon: ImageVector,
    val label: String
)