# Google Apps Script Setup (for moonedgestudio@gmail.com)

Aapne browser me jo **"Untitled project"** khola hua hai, usme ye setup karna hai.

---

### Step 1: Untitled Project me ye Code Paste karein:

Browser me jo project khula hai, usme `Code.gs` ka purana code hata kar ye exact script paste karein:

```javascript
/**
 * CYBER NINJA RUNNER - FEEDBACK DISPATCHER FOR MOON EDGE STUDIO
 * Direct Delivery to: moonedgestudio@gmail.com
 */

function doGet(e) {
  return ContentService.createTextOutput("Cyber Ninja Runner Feedback Service is Online & Ready!");
}

function doPost(e) {
  try {
    var rawData = e.postData.contents;
    var data = JSON.parse(rawData);

    var category = data.category || "GENERAL FEEDBACK";
    var userEmail = data.email || "Anonymous Shinobi";
    var message = data.message || "No description provided.";
    var timestamp = data.timestamp || new Date().toLocaleString();
    var telemetry = data.telemetry || {};

    // Format Telemetry Data
    var telemetryFormatted = "";
    if (telemetry && Object.keys(telemetry).length > 0) {
      telemetryFormatted += "\n\n================ SYSTEM TELEMETRY ================\n";
      for (var key in telemetry) {
        telemetryFormatted += "• " + key + ": " + telemetry[key] + "\n";
      }
      telemetryFormatted += "==================================================";
    }

    // Email Subject & Body matching Moon Edge Studio Sample
    var subject = "🎮 [Cyber Ninja Runner] [" + category + "] from " + userEmail;
    var body = 
      "Hello Moon Edge Studio!\n\n" +
      "A new in-app feedback / problem report was submitted from Cyber Ninja Runner:\n\n" +
      "• App: Cyber Ninja Runner (Protocol v2.5)\n" +
      "• Developer: Moon Edge Studio\n" +
      "• Category: " + category + "\n" +
      "• Player Contact: " + userEmail + "\n" +
      "• Time: " + timestamp + "\n\n" +
      "---------------- USER MESSAGE ----------------\n" +
      message + "\n" +
      "----------------------------------------------" +
      telemetryFormatted + "\n\n" +
      "Delivered securely via Google Apps Script Web App.";

    // Send direct email to moonedgestudio@gmail.com
    MailApp.sendEmail({
      to: "moonedgestudio@gmail.com",
      subject: subject,
      body: body,
      replyTo: (userEmail && userEmail.indexOf("@") !== -1) ? userEmail : "moonedgestudio@gmail.com"
    });

    return ContentService.createTextOutput(JSON.stringify({
      status: "success",
      message: "Feedback delivered to moonedgestudio@gmail.com"
    })).setMimeType(ContentService.MimeType.JSON);

  } catch (err) {
    return ContentService.createTextOutput(JSON.stringify({
      status: "error",
      message: err.toString()
    })).setMimeType(ContentService.MimeType.JSON);
  }
}

// Test Function (Aap Run button daba ke test email check kar sakte hain)
function testSendToMoonEdge() {
  MailApp.sendEmail({
    to: "moonedgestudio@gmail.com",
    subject: "🎉 [Cyber Ninja Runner] Feedback System is Live & Working!",
    body: "Hello Moon Edge Studio!\n\nYour Cyber Ninja Runner in-app feedback system is 100% connected and verified.\nUser feedbacks will arrive directly in your Gmail Inbox instantly.\n\n- App: Cyber Ninja Runner\n- Developer: Moon Edge Studio"
  });
}
```

---

### Step 2: Permissions Authorize karein (Ye step sabse zaroori hai!):
Google Apps Script me jab tak aap script editor se **ek baar Run** karke permission allow nahi karte, tab tak Google bahar se kisi ko access nahi deta (403 "You need access" deta hai):

1. Editor ke toolbar me function dropdown se **`testSendToMoonEdge`** select karein.
2. **Run (`▶`)** button par click karein.
3. Ek popup aayega: **"Authorization required"** -> **"Review permissions"** click karein.
4. Apna Google Account select karein.
5. Agar **"Google hasn’t verified this app"** screen aaye:
   - Niche **"Advanced"** par click karein.
   - Niche **"Go to Untitled project (unsafe)"** par click karein.
   - **"Allow"** button dabayein.
6. Done! Aapke `moonedgestudio@gmail.com` par ek test email bhi turant aa jayega!

---

### Step 3: Deployment Update karein (New Version):
Permission allow karne ke baad deployment ko update karna padta hai:

1. Upar **Deploy** -> **Manage deployments** par click karein.
2. Active deployment ke bagal me **Pencil icon (Edit)** dabayein.
3. Check karein:
   - **Version**: Dropdown se **"New version"** select karein.
   - **Execute as**: **`Me (...)`** hona chahiye (*"User accessing the web app" bilkul nahi hona chahiye*).
   - **Who has access**: **`Anyone`** hona chahiye.
4. **Deploy** button par click karein.

---

### Step 3: URL App me lagayein:

Uss URL ko chat me paste kar dijiye ya direct [`app_constants.dart`](file:///c:/Users/mailm/Documents/New%20folder/lib/core/constants/app_constants.dart#L52) me daal dein:
```dart
  static const String feedbackScriptUrl =
      'https://script.google.com/macros/s/AAPA_URL_YAHAN_DAALEIN/exec';
```

Bas! Uske baad koi bhi player jaise hi **TRANSMIT LOG** dabayega, turant seedhe **`moonedgestudio@gmail.com`** par email deliver ho jayega!
