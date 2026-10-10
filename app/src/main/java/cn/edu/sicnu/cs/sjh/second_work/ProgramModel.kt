package cn.edu.sicnu.cs.sjh.second_work

class ProgramModel {
    // 业务方法：输入语言名称，返回查询结果
    fun getAdvise(langName: String): String {
        return when(langName) {
            "apple" -> "苹果"
            "banana" -> "香蕉"
            "panapple" -> "菠萝"
            else -> ""
        }
    }
}
