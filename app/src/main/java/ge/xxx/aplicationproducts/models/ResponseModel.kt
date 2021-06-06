package ge.xxx.aplicationproducts.models

data class ResponseModel<T>(
    val code: Int,
    val data: T
)