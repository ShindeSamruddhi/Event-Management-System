import React, { useEffect, useState } from "react";

export default function EventList() {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    fetch("/api/events")
      .then((res) => res.json())
      .then((data) => setEvents(data))
      .catch((err) => console.error("Error loading events:", err));
  }, []);

  return (
    <div>
      <h2>All Events</h2>
      {events.length === 0 ? (
        <p>No events found.</p>
      ) : (
        <ul>
          {events.map((e) => (
            <li key={e.id}>
              <strong>{e.title}</strong> — {e.location} <br />
              {e.startTime ? new Date(e.startTime).toLocaleString() : ""}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
