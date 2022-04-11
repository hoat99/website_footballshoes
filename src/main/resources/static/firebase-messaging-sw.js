// Give the service worker access to Firebase Messaging.
// Note that you can only use Firebase Messaging here. Other Firebase libraries
// are not available in the service worker.
importScripts('https://www.gstatic.com/firebasejs/8.10.0/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.10.0/firebase-messaging.js');
importScripts(
    "https://www.gstatic.com/firebasejs/8.10.0/firebase-analytics.js",
);
// Initialize the Firebase app in the service worker by passing in
// your app's Firebase config object.
// https://firebase.google.com/docs/web/setup#config-object
firebase.initializeApp({
        apiKey: "AIzaSyDw6WftIFLse5KoBQ2-QgIoQkrV09g5Bkk",
        authDomain: "imagestorage-739d0.firebaseapp.com",
        projectId: "imagestorage-739d0",
        storageBucket: "imagestorage-739d0.appspot.com",
        messagingSenderId: "518618392590",
        appId: "1:518618392590:web:e40e237e88e7706f0e345f",
        measurementId: "G-B32H4GL2KV"
});

// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
let linkEven;
const messaging = firebase.messaging();

self.addEventListener('notificationclick', function(event){
    event.notification.close();
    event.waitUntil(
        clients.openWindow(linkEven));
});
messaging.setBackgroundMessageHandler(function(payload) {
    linkEven = payload.data.link;
    console.log(
        "[firebase-messaging-sw.js] Received background message ",
        payload,
    );
    // Customize notification here
    const notificationTitle = payload.data.title;
    const notificationOptions = {
        body: payload.data.content
    };
    return self.registration.showNotification(
        notificationTitle,
        notificationOptions,
    );
});