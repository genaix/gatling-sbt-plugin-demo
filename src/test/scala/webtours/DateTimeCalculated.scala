package webtours

import java.text.SimpleDateFormat
import java.time.Duration
import java.util.{Calendar, Date}


object DateTimeCalculated {
  val today: Date = Calendar.getInstance().getTime
  val dateFormat = new SimpleDateFormat("MM/dd/YYYY")
  val departureDate: String = dateFormat.format(today.getTime + Duration.ofHours(24).toMillis)
  val returnDate: String = dateFormat.format(today.getTime + Duration.ofHours(48).toMillis)
}
