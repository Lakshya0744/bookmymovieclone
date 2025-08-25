import { useState } from "react";
import { Card, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { useParams, useLocation } from "react-router-dom";

export default function ShowtimesPage() {
  const { id } = useParams();
  const { state } = useLocation();
  const movie = state?.movie;

  const [selectedDate, setSelectedDate] = useState(new Date().toDateString());
  const apiBase = window.RUNTIME_CONFIG?.API_BASE || "http://localhost:8081";

  if (!movie) {
    return <div className="p-6 text-red-400">Movie not found (id: {id})</div>;
  }

  const dates = Array.from({ length: 7 }, (_, i) => {
    const d = new Date();
    d.setDate(d.getDate() + i);
    return d.toDateString();
  });

  const showtimes = {
    "Screen 1": ["10:00 AM", "1:30 PM", "5:00 PM", "8:30 PM"],
    "Screen 2": ["11:00 AM", "2:30 PM", "6:00 PM", "9:30 PM"],
  };

  return (
    <div className="p-6 space-y-6">
      {/* Movie Header */}
      <div className="flex items-center gap-4">
        <img
          src={movie.posterUrl?.startsWith('/') ? `${apiBase}${movie.posterUrl}` : movie.posterUrl}
          alt={movie.title}
          className="w-20 h-28 rounded-lg shadow"
        />
        <div>
          <h1 className="text-2xl font-bold">{movie.title}</h1>
          <p className="text-gray-500">{movie.genre} • {movie.duration}</p>
        </div>
      </div>

      {/* Date Selector */}
      <div className="flex gap-2 overflow-x-auto pb-2">
        {dates.map((date) => (
          <Button
            key={date}
            variant={selectedDate === date ? "default" : "outline"}
            onClick={() => setSelectedDate(date)}
            className="rounded-full"
          >
            {date.split(" ").slice(0, 2).join(" ")}
          </Button>
        ))}
      </div>

      {/* Showtimes */}
      <div className="space-y-4">
        {Object.entries(showtimes).map(([screen, times]) => (
          <Card key={screen} className="p-4 shadow-md">
            <h2 className="font-semibold mb-3">{screen}</h2>
            <CardContent className="flex flex-wrap gap-3">
              {times.map((time) => (
                <Button
                  key={time}
                  variant="outline"
                  onClick={() => {
                    console.log("Selected:", screen, time, selectedDate);
                  }}
                  className="px-4 py-2 rounded-lg"
                >
                  {time}
                </Button>
              ))}
            </CardContent>
          </Card>
        ))}
      </div>
    </div>
  );
}