package com.example.cvbuilderapp.data

data class Certification(
    val logo: String,
    val name: String
) {
    companion object {
        fun getCertificateList(): MutableList<Certification> {
            return mutableListOf(
                Certification(
                    "https://images.credly.com/size/340x340/images/6f2a9ef8-4da2-4e67-bd52-84fbaa1af776/02_Java-SE-11-Developer_Professional__1_.png",
                    "Java SE 8 Programmer I (2020)"
                ),
                Certification(
                    "https://miro.medium.com/max/640/1*p4GiSyalLNb6WbngHir_Eg.webp",
                    "AWS Solutions Architect Associate"
                )
            )
        }
    }
}
