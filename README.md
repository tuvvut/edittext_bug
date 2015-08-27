在 Fragment 裡面，當你用到 EditText 或是 AutoCompleteTextView 時，無法在以下的方法（onCreateView、onViewCreated、onActivityCreated...等等，可能還有其他的）裡重新設定 text，只能在 onViewStateRestored、onResume 等方法裡重新設定，然而 Button 或 TextView 則沒這個問題。

問題示意圖：
![alt tag](https://github.com/tuvvut/edittext_bug/blob/master/sample.gif)
