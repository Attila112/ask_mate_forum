import { useState} from "react";
import { useAuth } from "../../AuthProvider";

export default function CreateAnswer({id, onAddAnswer}) {
    const [answerText, setAnswerText] = useState('');
    const {userId} = useAuth();

    const addAnswer = async (answer) => {
        const response = await fetch(`/api/answer/`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(answer),
        })
        return await response.json();
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        const answer = {
            description: answerText,
            question_id: id,
            user_id: userId,
        }
        await addAnswer(answer);
        onAddAnswer(false)
        setAnswerText("")
        // window.location.reload();
    }

    return <form onSubmit={handleSubmit}>
        <div>
            <label htmlFor='answer'>Add title</label>
            <input
                id='answer'
                value={answerText}
                onChange={(e) => setAnswerText(e.target.value)}
            />
        </div>
        <button type="submit">Submit Answer</button>
    </form>
}