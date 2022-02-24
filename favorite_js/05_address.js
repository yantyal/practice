document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("mail").addEventListener('change', function () {
        let mail = document.getElementById("form").mail.value;
        if (mail.lastIndexOf("com")!=-1) {
            document.getElementById("caution").textContent = "ドメインにcomが入っているので使用できません";
        } else {
            let atmark = mail.indexOf("@");
            if (atmark != -1) {
                let userName = mail.substring(0, atmark);
                document.getElementById("userName").value = userName;
            }
        }
    }, false);
});