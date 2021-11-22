alert("asda")
window.onload = function() {
    $(".check").click((e) => {
        var btn = $(e.currentTarget);
        var isDone = btn.attr("is-done");
        var id = btn.attr("data-post-id");
        $.put("/" + id, (data) => {
            if (isDone)
                btn.attr("text-decoration", "none");
            else
                btn.attr("text-decoration", "line-through");
        });
    });
};