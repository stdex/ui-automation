By default Chrome is opaque to the UI Automation API, but there is a way of  
turn on the support, and thus being able to navigate through the control hierarchy.

If you navigate to `chrome://accessibility/`, then you can turn accessibility on
globally or in a given page. Starting the application with the  
`--force-renderer-accessibility` option will start the application in the
correct mode.

An example of starting chrome with the correct settings is shown below. Note 
that is Chrome is already running, then the argument will have no effect. 

```
    UIAutomation automation = UIAutomation.getInstance();

    Application chrome =
        new Application(
            new ElementBuilder()
                .automation(automation)
                .applicationPath("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")
                .applicationArguments("--force-renderer-accessibility"));


    try {
        chrome.launchOrAttach();
    } catch (Throwable ex) {
        logger.warn("Failed to find application", ex);
    }
```


