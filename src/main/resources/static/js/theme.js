var darkMode = false;

if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
    darkMode = true;
}

if (localStorage.getItem('theme') === 'dark') {
    darkMode = true;
} else if (localStorage.getItem('theme') === 'light') {
    darkMode = false;
}

if (darkMode) {
    document.getElementById('theme').classList.toggle('dark');
}

document.addEventListener('DOMContentLoaded', () => {

    document.getElementById('themeBtn').addEventListener('click', () => {
        document.getElementById('theme').classList.toggle('dark');
        localStorage.setItem('theme', document.getElementById('theme').classList.contains('dark') ? 'dark' : 'light');
    });

});