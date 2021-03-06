package com.hochoy.spark

import java.text.SimpleDateFormat
import java.util.Date

import com.hochoy.spark.common.{Constants, Utils}
import org.joda.time.format.DateTimeFormat
import org.joda.time.{DateTime, Days}
import org.scalatest.FunSuite

/** Describe: the usages of joda-time
  * https://ylq365.iteye.com/blog/1769680
  *
  * Created by IntelliJ IDEA.
  * Time: 17:05
  *
  * @author hochoy <hochoy18@sina.com> 
  * @Version V1.0.0
  */
class JodaTest extends FunSuite {

//  def main(args: Array[String]): Unit = {
//    println(dateParse("2018-12-26 03:27"))
//    sys.exit(1)
//    joda_time_test
//    dateCompare
//    datetimeOperation
//  }

  def joda_time_test(): Unit = {
    val dt = new DateTime(2019, 1, 10, 17, 7, 0, 0)

    //时间解析
    var str1 = dt.toString("MM/dd/yy hh:mm:ss:SSS")
    println(str1)

    str1 = dt.toString(DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss"))
    println(str1)

    str1 = dt.toString("EEEE dd MMMM,yyyy HH:mm:ssa")
    println("EEEE dd MMMM,yyyy HH:mm:ssa^^^     " + str1)

    str1 = dt.toString("MM/dd/yyyy HH:mm ZZZZ")
    println("MM/dd/yyyy HH:mm ZZZZ^^^   " + str1)
    str1 = dt.toString("MM/dd/yyyy HH:mm Z")
    println("MM/dd/yyyy HH:mm Z^^^    " + str1)

  }

  def dateCompare: Unit = {

    val end = new DateTime
    val start = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2018-12-26 03:27:39")
    val days = Days.daysBetween(start, end).getDays
    println("dateCompare   " + days)
  }

  def datetimeOperation: Unit = {
    var datetime = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2018-12-26 03:27:39")
    println(datetime)
    datetime = datetime
      .plusDays(1)
      .minusHours(2)
      .plusYears(2)
      .minusWeeks(1)
    println(datetime)
  }

  def dateParse(date1: String): Boolean = {
    val date = {
      try {
        DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime(date1).toString
      } catch {
        case e: Exception ⇒ println(e); null
      }

    }
    println(s"date ...   ${date}")
    date == null
  }

  test("dateIsValid"){
    val d = Utils.dateIsValid("2018-12-12 12:12231")
    println("dd   "+d)
  }
  test("getNowTime"){
   println(Utils.getNowTime)
  }
import com.hochoy.spark.db._
  test("packageTest"){
    packageTest("hello ")
  }
}
