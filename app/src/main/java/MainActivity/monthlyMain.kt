/**
package MainActivity

import MainActivity.UserMeasurements
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidplot.xy.*
import com.example.chad.R
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import kotlin.collections.sortedBy

class monthlyMain : AppCompatActivity() {

    private lateinit var plot: XYPlot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_monthly)

        // Initialize plot from XML
        plot = findViewById(R.id.plot)

        // Example weekly measurements
        val monthlyMeasurements = generateMonthlyMeasurements()

        // Update combined plot
        updateCombinedPlot(monthlyMeasurements)
    }

    private fun generateMonthlyMeasurements(): List<UserMeasurements> {
        // Example generation of weekly measurements
        return listOf(
            UserMeasurements("2024-06-17", 50, 7, 6),
            UserMeasurements("2024-06-18", 60, 4, 7),
            UserMeasurements("2024-06-19", 70, 6, 6),
            UserMeasurements("2024-06-20", 80, 8, 6),
            UserMeasurements("2024-06-21", 75, 3, 5),
            UserMeasurements("2024-06-22", 65, 6, 7),
            UserMeasurements("2024-06-23", 60, 10, 6)
        )
    }

    private fun updateCombinedPlot(measurements: List<UserMeasurements>) {
        if (measurements.isEmpty()) {
            return
        }

        val sortedMeasurements = measurements.sortedBy { it.time }

        val domainLabels = sortedMeasurements.map { it.time }.toTypedArray()
        val moodSeriesValues = sortedMeasurements.map { it.moodValue }.toIntArray()
        val energySeriesValues = sortedMeasurements.map { it.energyLevel }.toIntArray()
        val sleepSeriesValues = sortedMeasurements.map { it.sleepHours }.toIntArray()

        // Clear previous series
        plot.clear()

        // Add mood series
        val moodSeries = SimpleXYSeries(moodSeriesValues.asList(), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Mood")
        val moodFormat = LineAndPointFormatter(Color.BLUE, null, null, null)
        plot.addSeries(moodSeries, moodFormat)

        // Add energy series
        val energySeries = SimpleXYSeries(energySeriesValues.asList(), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Energy Level")
        val energyFormat = LineAndPointFormatter(Color.RED, null, null, null)
        plot.addSeries(energySeries, energyFormat)

        // Add sleep series
        val sleepSeries = SimpleXYSeries(sleepSeriesValues.asList(), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Sleep Hours")
        val sleepFormat = LineAndPointFormatter(Color.GREEN, null, null, null)
        plot.addSeries(sleepSeries, sleepFormat)

        // Format plot
        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).format = object : Format() {
            override fun format(obj: Any?, toAppendTo: StringBuffer?, pos: FieldPosition?): StringBuffer {
                val i = obj as Int
                return toAppendTo!!.append(domainLabels[i])
            }

            override fun parseObject(source: String?, pos: ParsePosition?): Any {
                return 0
            }
        }

        // Refresh plot
        plot.redraw()
    }
}
*/