package source_code_imitate

/**
 * 测量规格为32位整型，
 * 高两位保存测量模式，
 * 低30位保存测量尺寸
 */
class MeasureSpec {

    private val MODE_SHIFT = 30
    private val MODE_MASK = 0x3 shl (MODE_SHIFT)
    private val MODE_UNSPECIFIED = 0x0 shl (MODE_SHIFT)
    private val MODE_EXACTLY = 0x1 shl (MODE_SHIFT)
    private val MODE_ATMOST = 0x2 shl (MODE_SHIFT)

    /**
     * 将测量模式打包成一个测量规格类
     */
    fun makeMeasureSpec(size: Int, mode: Int): Int {
        return (mode and MODE_MASK) or (size and MODE_MASK.inv())
    }

    /**
     * 获取测量模式
     */
    fun getMode(measureSpec: Int): Int {
        return measureSpec and MODE_MASK
    }

    /**
     *获取测量尺寸
     */
    fun getSize(measureSpec: Int): Int {
        return measureSpec and MODE_MASK.inv()
    }
}