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

class weeklyMain : AppCompatActivity() {
    private lateinit var home: ImageButton
    private lateinit var plot: XYPlot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_weekly)

        // Initialize plot from XML
        plot = findViewById(R.id.plotWeekly)

        home = findViewById(R.id.homeWeekly)

        home.setOnClickListener {
            homeMain()
        }


        // Example weekly measurements
        val weeklyMeasurements = generateWeeklyMeasurements()

        // Update combined plot
        updateCombinedPlot(weeklyMeasurements)
    }

    private fun generateWeeklyMeasurements(): List<UserMeasurement> {
        // Example generation of weekly measurements
        return listOf(
            UserMeasurement("2024-06-17", 50, 70, 6),
            UserMeasurement("2024-06-18", 60, 40, 7),
            UserMeasurement("2024-06-19", 70, 60, 6),
            UserMeasurement("2024-06-20", 80, 80, 6),
            UserMeasurement("2024-06-21", 75, 30, 5),
            UserMeasurement("2024-06-22", 65, 60, 7),
            UserMeasurement("2024-06-23", 60, 100, 6)
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
