package com.kienht.gapo.post_details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kienht.gapo.post_details.model.CommentViewData
import com.kienht.gapo.post_details.model.CommentsLiveData
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class PostDetailsViewModel @Inject constructor() : ViewModel() {

    val myAvatarUrl: String = "https://i.ibb.co/frD0Thn/avatar-kienht.jpg"
    val caption: String = "Râu hùm, hàm én, mày ngài.\nVai năm tấc rộng, thân mười thước cao."

    private val postId = 69L

    private val comments = listOf<CommentViewData>(
        CommentViewData(
            0,
            postId,
            "Ngọc Trinh",
            "https://i.ibb.co/NyDD5PD/avatar-ngoc-trinh.jpg",
            "Ngon zai quá ạ!",
            "Vừa xong",
            listOf<CommentViewData>(
                CommentViewData(
                    10,
                    0,
                    "Mai Thu Hiền",
                    "https://i.ibb.co/xjQrpjq/avatar-mai-thu-hien.jpg",
                    "Chào Ngọc Trinh...",
                    "Vừa xong"
                ),
                CommentViewData(
                    11,
                    0,
                    "Huyền Thanh Chu Thị",
                    "https://i.ibb.co/k9wLmhZ/avatar-huyen-thanh-chu-thi.jpg",
                    "Chào Ngọc Trinh...",
                    "6 phút"
                ),
                CommentViewData(
                    12,
                    0,
                    "BeatVN",
                    "https://i.ibb.co/DkWZ4Rc/avatar-beat-vn.png",
                    "Ngọc Trinh đang làm gì thế?",
                    "9 phút"
                )
            )
        ),
        CommentViewData(
            1,
            postId,
            "Mai Thu Hiền",
            "https://i.ibb.co/xjQrpjq/avatar-mai-thu-hien.jpg",
            "Tuyệt vời!",
            "5 phút",
            listOf<CommentViewData>(
                CommentViewData(
                    13,
                    1,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks!",
                    "Vừa xong"
                )
            )
        ),
        CommentViewData(
            2,
            postId,
            "Tuyết Loan Nguyễn",
            "https://i.ibb.co/DtPkMNN/avatar-tuyet-loan-nguyen.jpg",
            "Wowwwwwwwww!",
            "9 phút",
            listOf<CommentViewData>(
                CommentViewData(
                    14,
                    2,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks!",
                    "Vừa xong"
                )
            )
        ),
        CommentViewData(
            3,
            postId,
            "Tuấn Hưng",
            "https://i.ibb.co/J7yWSPP/avatar-tuan-hung.jpg",
            "Quá tuyệt vời em!",
            "30 phút",
            listOf<CommentViewData>(
                CommentViewData(
                    15,
                    3,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks anh!",
                    "Vừa xong"
                )
            )
        ),
        CommentViewData(
            4,
            postId,
            "Trần Thu Hương",
            "https://i.ibb.co/3yhwYg6/avatar-tran-thu-huong.jpg",
            "Tuyệt vời em tôi!",
            "1 tiếng",
            listOf<CommentViewData>(
                CommentViewData(
                    16,
                    4,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks chị!",
                    "Vừa xong"
                )
            )
        ),
        CommentViewData(
            5,
            postId,
            "Phan Mạnh Quỳnh",
            "https://i.ibb.co/7rLF8Cd/avatar-phan-manh-quynh.jpg",
            "Đã xem và không thể nói gì!",
            "2 tiếng",
            listOf<CommentViewData>(
                CommentViewData(
                    17,
                    5,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks anh!",
                    "Vừa xong"
                ),
                CommentViewData(
                    18,
                    5,
                    "Phan Mạnh Quỳnh",
                    "https://i.ibb.co/7rLF8Cd/avatar-phan-manh-quynh.jpg",
                    "Ok chú.",
                    "Vừa xong"
                )
            )
        ),
        CommentViewData(
            6,
            postId,
            "Nguyễn Mỹ Hạnh",
            "https://i.ibb.co/9gfbzJb/avatar-nguyen-my-hanh.jpg",
            "Ngon zai quá ạ!",
            "6 tiếng",
            listOf<CommentViewData>(
                CommentViewData(
                    19,
                    6,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks!",
                    "Vừa xong"
                )
            )
        ),
        CommentViewData(
            7,
            postId,
            "Nguyễn Lan Phương",
            "https://i.ibb.co/TvTHvYb/avatar-nguyen-lan-phuong.jpg",
            "Ngon zai quá ạ!",
            "Hôm qua",
            listOf<CommentViewData>(
                CommentViewData(
                    20,
                    7,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks!",
                    "Vừa xong"
                )
            )
        ),
        CommentViewData(
            8,
            postId,
            "Nguyễn Kiều My",
            "https://i.ibb.co/n60Chv3/avatar-nguyen-kieu-my.jpg",
            "Ngon zai quá ạ!",
            "1 tuần",
            listOf<CommentViewData>(
                CommentViewData(
                    21,
                    8,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks!",
                    "Vừa xong"
                )
            )
        ),
        CommentViewData(
            9,
            postId,
            "Bùi Bích Phương",
            "https://i.ibb.co/QHcdj3L/avatar-bui-bich-phuong.jpg",
            "Ngon zai quá ạ!",
            "1 tháng",
            listOf<CommentViewData>(
                CommentViewData(
                    22,
                    9,
                    "KienHT",
                    myAvatarUrl,
                    "Thanks!",
                    "Vừa xong"
                )
            )
        )
    )

    val commentsLiveData: LiveData<List<CommentViewData>>
        get() = _commentsLiveData
    private val _commentsLiveData = CommentsLiveData(comments)

}