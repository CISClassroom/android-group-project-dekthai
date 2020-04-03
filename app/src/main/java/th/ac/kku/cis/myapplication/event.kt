package th.ac.kku.cis.myapplication

class eventmodel {
    companion object Factory {
        fun create(): eventmodel = eventmodel()
    }
    var id: String? = null
    var name: String? = null
    var event: String? = null
    var unit: String? = null
    var side: String? = null
}