<html>
<body>
<script typet="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<h2>Hello World!</h2>
<button id="btn" onclick="submitThis()">Press to send List</button>

<script type="text/javascript">
    function submitThis() {
        var  testList = [];
        var user={};
        user.id=1;
        user.name="Rose";
        testList.push(user);

        var user2={};
        user2.id=2;
        user2.name="Jack";
        testList.push(user2);
        $.ajax({

            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'POST',
            dataType: "json",
            data: JSON.stringify(testList),
            url:'/postList',
            success: function () {
                alert('success');
            }

        });
    }
</script>
</body>
</html>
