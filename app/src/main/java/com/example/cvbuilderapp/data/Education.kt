package com.example.cvbuilderapp.data

data class Education(
    val collegeName: String,
    val program: String,
    val logo: String
) {

    companion object {
        fun getEducationList() : MutableList<Education> {
            return mutableListOf(
                Education(
                    "Maharishi Internation University",
                    "Master's in Computer Science",
                    "https://maharishischool.org/wp-content/uploads/MaharishiSchoolTreeLogo-8cc541-green.jpg"
                ),
                Education(
                    "Multimedia University of Kenya",
                    "Bachelor of science in Software Engineering",
                    "https://scontent-dfw5-2.xx.fbcdn.net/v/t31.18172-8/884442_118689361653503_1159126515_o.png?_nc_cat=106&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=JpdYAfBQPu8AX-vE5nk&_nc_ht=scontent-dfw5-2.xx&oh=00_AfAUggO1CTIC64Xxi_Wk2C_WZhgsdv2KQumO3ueFQr_Qcw&oe=63BCD59E"
                )
            )
        }
    }
}
