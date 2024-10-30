package id20210822.class154058.gmailclone

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var lv: ListView

    private val gmailTitle = listOf(
        "DevLearning.com", "Sam from AI Tips", "DesignCo", "Tech Support", "Jessica from DevHub",
        "Marketing Weekly", "App Insights", "Customer Care", "New Horizons", "Tech Deals",
        "StartupHub", "CreativePro", "EduMasters", "Tech World", "Growth Hacks",
        "DevTalks", "Cloud Solutions", "Career Insights", "Web Genie", "The Code Pit"
    )

    private val gmailTime = listOf(
        "3:45 PM", "1:12 PM", "12:30 PM", "11:10 AM", "8:45 AM",
        "5:15 PM", "4:50 PM", "2:10 PM", "11:55 AM", "10:20 AM",
        "9:05 AM", "8:45 AM", "7:30 AM", "6:25 AM", "5:15 AM",
        "4:00 AM", "3:10 AM", "1:40 AM", "12:10 AM", "11:55 PM"
    )

    private val gmailText = listOf(
        "50% Off for First-Time Users!\nJoin us to explore hands-on coding tutorials...",
        "Free Ebook - The Ultimate Guide to AI!\nGet your copy today, no cost to you...",
        "New Design Tools Available\nLatest features in graphic design and UX/UI...",
        "Your Support Ticket has been Updated\nPlease log in to view the latest update...",
        "Join Our Developer Community!\nConnect, learn, and grow with fellow developers...",
        "Top Marketing Trends of 2024\nStay ahead with insights from industry leaders...",
        "Your Monthly App Report\nSee your app's performance stats and user feedback...",
        "Customer Support Follow-up\nYour case ID: 12345 has been resolved successfully...",
        "Explore the Latest Courses\nAdvance your career with our expert-led courses...",
        "Biggest Tech Deals This Week!\nExclusive discounts for members only...",
        "Launch Your Startup Idea\nAccess resources to turn your vision into reality...",
        "New CreativePro Tutorials\nMaster Photoshop, Illustrator, and more...",
        "Exclusive: Data Science Program\nEnroll today and kickstart your data journey...",
        "Tech World News - October Edition\nCatch up on the latest in tech and gadgets...",
        "Weekly Growth Hacks Digest\nMarketing tips and tricks to boost your business...",
        "DevTalks Event Coming Soon!\nJoin us for an exciting developer conference...",
        "Upgrade to Cloud Solutions Plus\nGet more storage and advanced tools...",
        "Career Insights: Jobs of the Future\nPrepare yourself for emerging job roles...",
        "Boost Your Website’s SEO\nLearn how to rank higher in search results...",
        "Code Challenges for Fun & Practice\nSharpen your skills with daily challenges..."
    )


    private val myList: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.lv)

        val random = Random()
        for (i in gmailTitle.indices) {
            val avatar = gmailTitle[i].first().uppercase()
            val colorAvatar = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
            val drawable = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setSize(50, 50)
                setColor(colorAvatar)
            }
            myList.add(User(avatar, gmailTitle[i], gmailTime[i],gmailText[i], isStarred = false, drawable))
        }

        val adapter = GmailAdapter(this, R.layout.gmail_item, myList)
        lv.adapter = adapter

    }
}