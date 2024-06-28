package MainActivity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.androidplot.xy.*
import com.example.chad.R
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.sortedBy

class monthlyMain : AppCompatActivity() {
    private lateinit var home: ImageButton
    private lateinit var plot: XYPlot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_monthly)

        // Initialize plot from XML
        plot = findViewById(R.id.plotMonthly)

        home = findViewById(R.id.homeMonthly)

        home.setOnClickListener {
            homeMain()
        }


        // Example weekly measurements
        val monthlyMeasurement = generateMonthlyMeasurement()

        // Update combined plot
        updateCombinedPlot(monthlyMeasurement)
    }

    private fun generateMonthlyMeasurement(): List<UserMeasurement> {
        // Example generation of weekly measurements
        return listOf(
            UserMeasurement("2024-06-17", 50, 70, 6),
            UserMeasurement("2024-06-18", 60, 40, 7),
            UserMeasurement("2024-06-19", 70, 60, 6),
            UserMeasurement("2024-06-20", 80, 80, 6),
            UserMeasurement("2024-06-21", 75, 30, 5),
            UserMeasurement("2024-06-22", 65, 60, 7),
            UserMeasurement("2024-06-23", 60, 100, 6),
            UserMeasurement("2024-06-16", 55, 50, 7),
            UserMeasurement("2024-06-15", 65, 40, 6),
            UserMeasurement("2024-06-14", 70, 70, 5),
            UserMeasurement("2024-06-13", 80, 90, 6),
            UserMeasurement("2024-06-12", 85, 20, 7),
            UserMeasurement("2024-06-11", 75, 60, 6),
            UserMeasurement("2024-06-10", 65, 80, 5),
            UserMeasurement("2024-06-09", 60, 70, 7),
            UserMeasurement("2024-06-08", 70, 50, 6),
            UserMeasurement("2024-06-07", 75, 60, 5),
            UserMeasurement("2024-06-06", 80, 100, 7),
            UserMeasurement("2024-06-05", 85, 30, 6),
            UserMeasurement("2024-06-04", 75, 50, 5),
            UserMeasurement("2024-06-03", 65, 90, 6),
            UserMeasurement("2024-06-02", 60, 80, 7),
            UserMeasurement("2024-06-01", 70, 60, 6),
            UserMeasurement("2024-05-31", 80, 40, 5),
            UserMeasurement("2024-05-30", 85, 70, 7),
            UserMeasurement("2024-05-29", 75, 20, 6),
            UserMeasurement("2024-05-28", 65, 60, 5),
            UserMeasurement("2024-05-27", 60, 50, 7),
            UserMeasurement("2024-05-26", 70, 90, 6),
            UserMeasurement("2024-05-25", 80, 100, 5)

        )
    }

    private fun updateCombinedPlot(measurements: List<UserMeasurement>) {
        if (measurements.isEmpty()) {
            return
        }

        val sortedMeasurements = measurements.sortedBy { it.time }

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val domainLabels = sortedMeasurements.map { it.time }
        val domainValues = sortedMeasurements.map { dateFormat.parse(it.time)?.time?.toFloat() ?: 0f }
        val moodSeriesValues = sortedMeasurements.map { it.moodValue.toFloat() }
        val energySeriesValues = sortedMeasurements.map { it.energyLevel.toFloat() }
        val sleepSeriesValues = sortedMeasurements.map { it.sleepHours.toFloat() }

        // Clear previous series
        plot.clear()

        // Add mood series
        val moodSeries = SimpleXYSeries(
            domainValues,
            moodSeriesValues,
            "Mood"
        )
        val moodFormat = LineAndPointFormatter(Color.BLUE, null, null, null)
        plot.addSeries(moodSeries, moodFormat)

        // Add energy series
        val energySeries = SimpleXYSeries(
            domainValues,
            energySeriesValues,
            "Energy Level"
        )
        val energyFormat = LineAndPointFormatter(Color.RED, null, null, null)
        plot.addSeries(energySeries, energyFormat)

        // Add sleep series
        val sleepSeries = SimpleXYSeries(
            domainValues,
            sleepSeriesValues,
            "Sleep Hours"
        )
        val sleepFormat = LineAndPointFormatter(Color.GREEN, null, null, null)
        plot.addSeries(sleepSeries, sleepFormat)

        // Format plot
        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).format = object : Format() {
            override fun format(
                obj: Any?,
                toAppendTo: StringBuffer?,
                pos: FieldPosition?
            ): StringBuffer {
                val i = (obj as Number).toFloat().toLong()
                return toAppendTo!!.append(dateFormat.format(Date(i)))
            }

            override fun parseObject(source: String?, pos: ParsePosition?): Any {
                return 0
            }
        }

        // Redraw the plot
        plot.redraw()
    }

    private fun homeMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
