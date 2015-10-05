@Grab(group='org.jsoup', module='jsoup', version='1.7.2')
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


//Update this URL to the page you need to scrape
String urlToScrape = "http://"
//Adjust the CSS selector to meet your needs.
String cssSelector = ""

//Need to run this over TOR? Un-comment the following line. You can even scrape onions!
//System.properties.putAll( ["proxySet":"true","socksProxyHost":"localhost", "socksProxyPort":"9050"] )
Document doc = Jsoup.connect(urlToScrape).get();

String secretText = doc.select(cssSelector).text()

def cowsayCommand = """cowsay $secretText"""
println cowsayCommand.execute().in.text
