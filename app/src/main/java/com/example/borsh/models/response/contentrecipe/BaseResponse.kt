package com.example.borsh.models.response.contentrecipe

class BaseResponse<T>(
    val success: Boolean,
    val content: T
)