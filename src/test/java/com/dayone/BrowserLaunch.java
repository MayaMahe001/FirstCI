package com.dayone;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.*;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class BrowserLaunch {
    public static void main(String[] args) {

        Playwright play = Playwright.create();
        LaunchOptions lp = new LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        Browser brow = play.chromium().launch(lp);
        Page page = brow.newPage();
        page.navigate("https:www.facebook.com");
        Locator email = page.locator("id=email");
        email.fill("One");
        Locator pass = page.locator("id=pass");
        pass.fill("two");
//        Locator loginBtn = page.locator("//button[@name='login']");
//        loginBtn.click();
        String title = page.title();
        System.out.println(title);
        System.out.println(page.url());
        System.out.println(page.content());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("C:\\Users\\91893\\IdeaProjects\\PlaywrightSession\\src\\test\\ScreenShot\\one.png")));

    }
}
