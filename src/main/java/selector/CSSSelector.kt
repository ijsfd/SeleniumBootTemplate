package selector

import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

class CSSSelector(driver: RemoteWebDriver) : Selector(driver) {
    override fun findElement(selector: String): WebElement {
        return driver.findElement(cssSelector(selector))

    }

    override fun findAll(selector: String): List<WebElement> {
        val webElements = arrayListOf<WebElement>()
        var i = 0
        while (elementExists("""$selector[${i}]""")) {
            webElements.add(findElement("""$selector[${i}]"""))
            i++
        }
        return webElements
    }

    override fun elementExists(selector: String): Boolean {
        val element: WebElement = driver.findElement(cssSelector(selector))
        return super.elementExists(element)
    }

    override fun click(selector: String): Boolean {
        val element: WebElement = driver.findElement(cssSelector(selector))
        return super.click(element)
    }

    override fun setText(selector: String, text: String): Boolean {
        val element: WebElement = driver.findElement(cssSelector(selector))
        return super.setText(element, text)
    }

    override fun waitForElement(selector: String): Boolean {
        val element: WebElement = driver.findElement(cssSelector(selector))
        return super.waitForElement(element)
    }
}