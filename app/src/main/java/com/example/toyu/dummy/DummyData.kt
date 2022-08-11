package com.example.toyu.dummy

import com.example.toyu.R
import com.example.toyu.data.vos.ToyImageVO
import com.example.toyu.data.vos.ToyVO
import com.example.toyu.data.vos.UserVO
import com.example.toyu.utils.*

val user1 = UserVO("u01", "Thomas", "https://cdn.pixabay.com/photo/2018/08/04/10/23/man-3583424_1280.jpg")
val user2 = UserVO("u02", "Kelly", "https://c8.alamy.com/comp/MRPM90/young-man-cartoon-MRPM90.jpg")
val user3 = UserVO("u03", "Mikel", "https://image.shutterstock.com/image-vector/business-person-cartoon-cute-female-600w-1549172948.jpg")
val user4 = UserVO("u04", "John", "https://www.pngitem.com/pimgs/m/28-286504_face-man-cartoon-human-adult-person-male-.png")
val user5 = UserVO("u05", "Harry", "https://us.123rf.com/450wm/artenot/artenot1205/artenot120500394/13499036-funny-cartoon-casual-man-in-various-poses-for-use-in-advertising-presentations-brochures-blogs-docum.jpg?ver=6")

val toyImage1 = ToyImageVO("i01", "https://www.linkpicture.com/q/Image-7_2.png", "green", "#4ab426")
val toyImage2 = ToyImageVO("i02", "https://www.linkpicture.com/q/Group2.png", "orange", "#fe8700")
val toyImage3 = ToyImageVO("i03", "https://www.linkpicture.com/q/Group3.png", "violet", "#9C64FF")
val toyImage4 = ToyImageVO("i04", "https://www.linkpicture.com/q/Group_7.png", "pink", "#FF6464")
val toyImage5 = ToyImageVO("i05", "https://www.linkpicture.com/q/Mask-Group-3_1.png", "blue", "#9ad6ff")
val toyImage6 = ToyImageVO("i06", "https://www.linkpicture.com/q/Mask-Group-4_1.png", "yellow", "#fdd553")
val toyImage7= ToyImageVO("i07", "https://www.linkpicture.com/q/Image-7_2.png", "orange", "#fe8700")
val toyImage8 = ToyImageVO("i08", "https://www.linkpicture.com/q/Group2.png", "violet", "#9C64FF")
val toyImage9 = ToyImageVO("i09", "https://www.linkpicture.com/q/Group3.png", "pink", "#FF6464")
val toyImage10 = ToyImageVO("i10", "https://www.linkpicture.com/q/Image_15-removebg-preview.png", "blue", "#9ad6ff")



val toy1 = ToyVO("t01", "Mini Bot", TOY_CATEGORY_NEW, AGE_CATEGORY_03, 75.00,
    4.0, "This balancing game encourages your little one to move carefully, think critically and play imaginatively, all while enjoying a fun and interactive game.",
    user1, arrayListOf(toyImage1, toyImage2, toyImage3, toyImage4, toyImage5), 5)

val toy2 = ToyVO("t02", "Plastic Train", TOY_CATEGORY_EXCLUSIVE, AGE_CATEGORY_07,
    25.00, 3.5, "This balancing game encourages your little one to move carefully, think critically and play imaginatively, all while enjoying a fun and interactive game.",
    user2, arrayListOf(toyImage5, toyImage4, toyImage3),
    3, PROMOTION_50_DISCOUNT)

val toy3 = ToyVO("t03", "Controller", TOY_CATEGORY_NEW_RELEASE, AGE_CATEGORY_14,
    50.00, 5.0, "This balancing game encourages your little one to move carefully, think critically and play imaginatively, all while enjoying a fun and interactive game.",
    user3, arrayListOf(toyImage6, toyImage9, toyImage10, toyImage7), 4)

val toy4 = ToyVO("t04", "Crocodile", TOY_CATEGORY_LIMITED, AGE_CATEGORY_03,
    35.00, 3.0, "This balancing game encourages your little one to move carefully, think critically and play imaginatively, all while enjoying a fun and interactive game.",
    user4, arrayListOf(toyImage10, toyImage9, toyImage8, toyImage7), 4, PROMOTION_BO_GO)

val toy5 = ToyVO("t05", "Remote Submarine", TOY_CATEGOTY_POPULAR, AGE_CATEGORY_07,
    70.00, 4.0, "This balancing game encourages your little one to move carefully, think critically and play imaginatively, all while enjoying a fun and interactive game.",
    user5, arrayListOf(toyImage2, toyImage4, toyImage3, toyImage5, toyImage1), 5, PROMOTION_30_DISCOUNT)

fun getDummyToyList() : List<ToyVO>{
    return listOf(toy1, toy2, toy3, toy4, toy5)
}