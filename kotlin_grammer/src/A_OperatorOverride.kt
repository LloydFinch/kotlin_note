/**
 * 运算符重载
 * +a a.unaryPlus
 * -a a.unaryMinus()
 * !a a.not()
 *
 * a++ a.inc()
 * a-- a.dec()
 *
 * a+b a.plus(b)
 * a-b a.minus(b)
 * a*b a.times(b)
 * a/b a.div(b)
 * a%b a.rem(b)或a.mod(b)(已弃用 from 1.1)
 * a..b a.rangeTo(b)
 *
 * a in b b.contains(a)
 * a !in b !b.contains(a)
 *
 * a[i] a.get(i)
 * a[i,j] a.get(i,j)
 * a[i_1, ..., i_n]  a.get(i-1, ..., i_n)
 * a[i]= b a.set(i,b)
 * a[i,j] = b s.set(i,j,b)
 * a[i_1, ..., i_n] = b a.set(i_1, ..., i_n, b)
 *
 * a() a.invoke()
 * a(i) a.invoke(i)
 * a(i,j) a.invoke(i,j)
 * a(i_1, ..., i_n) a.invoke(i_1, ..., i_n)
 *
 * a+=b a.plusAssign(b)
 * a-=b a.minusAssign(b)
 * a*=b a.timesAssign(b)
 * a/=b a.divAssign(b)
 * a%=b a.remAssign(b)或a.modAssign(b)(已弃用 form 1.1)
 *
 * ===和!==不可重载
 * a==b a?.equals(b)?:(b===null)
 * a!=b !(a?.equals(b)?:(b===null))
 *
 * a>b a.compareTo(b) > 0
 * a<b a.compareTo(b) < 0
 * a>=b a.compareTo(b) >=0
 * a<=b a.compareTo(b) <=0
 */


fun main() {
    /**
     * 将-应用于PointX
     */
//    println(-pointX)


    val temp = pointX.unaryMinus()

    println((-pointX))
    println(temp)
//    println(pointX + (-pointX))


}


data class PointX(val x: Int, val y: Int)

operator fun PointX.unaryMinus() = PointX(-x, -y)
val pointX = PointX(10, 20)

operator fun PointX.plus(pointX: PointX): PointX = PointX(this.x + pointX.x, this.y + pointX.y)

