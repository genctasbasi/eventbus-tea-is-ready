# eventbus-tea-is-ready
A sample app on how to use greenrobot's EventBus library.

For more details, please see  http://androidandotherthings.com/android-event-bus-sample

![EventBus](http://androidandotherthings.com/images/event_bus_app.png)

In our sample project, we'll have one Activity and two Fragments. We'll also define 3 events:

Tea is ready event (basically TeaIsReadyEvent class in the code)
Coffee is ready event (basically CoffeeIsReadyEvent class in the code)
Nothing is ready event (basically NothingIsReadyEvent class in the code)
The Activity will have 3 buttons to fire these 3 events. Therefore our Activity will be the 'publisher'.

One of the Fragments (Fragment 1 as seen in the diagram) will register for TeaIsReadyEvent.

Other Fragment (Fragment 2 in the diagram) is only interested in coffee so it'll register for CoffeeIsReadyEvent.

Both of the Fragments are also interested in NothingIsReadyEvent.

When we (as a user) tap the buttons on the Activity, the Fragment registered for that particular event will respond!

![EventBus diagram](http://androidandotherthings.com/images/event_bus_diagram.png)

