package com.example.cvbuilderapp.data

data class Work(
    val companyName: String,
    val fromDate: String,
    val toDate: String,
    val location: String,
    val logo: String,
    val roles: String
) {
    companion object {
        fun getWorkList() : MutableList<Work> {
            return mutableListOf(
                Work(
                    "Centum Investments",
                    "Jan 2019",
                    "Mar 2023",
                    "Nairobi, Kenya",
                    "https://seekvectorlogo.com/wp-content/uploads/2018/01/centum-investment-vector-logo-small.png",
                    "Software Engineer"
                ),
                Work(
                    "McDave Holdings",
                    "Jan 2018",
                    "Dec 2018",
                    "Nairobi, Kenya",
                    "https://www.mcdave.co.ke/images/logo.png",
                     "Software Developer"
                )
            )
        }
    }
}
