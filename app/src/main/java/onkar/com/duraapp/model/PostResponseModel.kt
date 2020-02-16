package onkar.com.duraapp.model

data class PostResponseModel(
        var post_id: Int,
        val details: List<SomeModel>
)