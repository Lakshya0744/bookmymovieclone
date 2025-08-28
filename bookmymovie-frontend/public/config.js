const isLocal =
  window.location.hostname === "localhost" ||
  window.location.hostname.startsWith("192.168.") ||
  window.location.hostname === "127.0.0.1";

window.RUNTIME_CONFIG = {
  API_BASE: isLocal
    ? "http://192.168.0.152:8081"         // local backend
    : "https://bookmymovie-backend-9bg7.onrender.com/" // render backend
};