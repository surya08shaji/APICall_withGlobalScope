package com.example.globalscope.data.model

data class ResponseModel(val count: Int,
                         val lastItemIndex: Int,
                         val page: Int,
                         val results: List<ResultModel>,
                         val totalCount: Int,
                         val totalPages: Int)
