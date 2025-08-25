import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function MovieGrid() {
  const [movies, setMovies] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    const controller = new AbortController();
    const fetchMovies = async () => {
      try {
        setLoading(true);
        const apiBase = window.RUNTIME_CONFIG?.API_BASE || "http://localhost:8081";
        const res = await fetch(`${apiBase}/movies`, { signal: controller.signal });
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const data = await res.json();
        setMovies(data);
      } catch (err) {
        if (err.name !== "AbortError") setError("Failed to load movies");
      } finally {
        setLoading(false);
      }
    };
    fetchMovies();
    return () => controller.abort();
  }, []);

  if (loading) return <div className="p-6 text-white">Loading...</div>;
  if (error) return <div className="p-6 text-red-400">{error}</div>;

  const apiBase = window.RUNTIME_CONFIG?.API_BASE || "http://localhost:8081";
  console.log("window.RUNTIME_CONFIG", window.RUNTIME_CONFIG);

  return (
    <div className="p-6 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
      {movies.map((movie) => (

        <div
          key={movie.id ?? movie.title}
          className="bg-gray-900 rounded-lg overflow-hidden shadow-lg hover:cursor-pointer hover:scale-105 transition-transform"
          onClick={() => navigate(`/showtimes/${movie.id}`, { state: { movie } })}
        >
          <img
            src={movie.posterUrl?.startsWith('/') ? `${apiBase}${movie.posterUrl}` : movie.posterUrl}

            alt={movie.title}
            className="w-full h-[450px] object-cover"
          />
          <div className="p-4">
            <h3 className="text-lg font-bold text-white">{movie.title}</h3>
            <p className="text-sm text-gray-400">{movie.language}</p>
          </div>
        </div>
      ))}
    </div>
  );
}