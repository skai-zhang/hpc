let anchor = {
    total: 0,
    load: 0
};
const asyncScript = {
    init: function () {
        if (conf.network.online) {
            this.load(conf.resources.online);
        } else {
            this.load(conf.resources.offline);
        }
    },
    load: function (list) {
        anchor = {
            total: list.length,
            ready: list.length - 1,
            load: 0
        }
        setTimeout(function () { $("#loading").addClass("over"); }, 500);
        for (let num in list) {
            console.log("asyncScript: 开始加载 " + list[num]);
            $.getScript(list[num], this.stepping);
        }
        this.ready();
    },
    ready: function () {
        let interval = setInterval(function () {
            if (anchor.load === anchor.total) {
                $.getScript("res/js/app.js", function () {
                    console.log("asyncScript: 脚本加载完成,开始初始化");
                    initApp();
                    clearInterval(interval);
                });
                console.log("asyncScript: 开始加载 res/js/app.js");
            }
        }, 1000);
    },
    stepping: function () {
        anchor.load++;
    }
}

function initApp(){
    extractConfig();
    $("body").niceScroll();
    setTimeout(function () { $("title").text(conf.title); $("#loading").fadeOut(); }, 1200);
    setTimeout(function () { $("#loading").remove(); }, 2000);
}

function extractConfig(){
    $(".app-name").html(conf.name);
    $("#search-input").attr("placeholder",conf.search.placeholder);
}

function search(){

}