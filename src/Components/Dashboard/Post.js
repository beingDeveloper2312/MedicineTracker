import AddIcon from '@mui/icons-material/Add';
import CancelIcon from '@mui/icons-material/Cancel';
import DoneIcon from '@mui/icons-material/Done';
import { useRecoilState } from 'recoil';
import { useEffect } from 'react';
import { medList } from '../../Atoms/medAtom';
import './Post.css';
import { useState } from 'react';
const Post = () => {
    const [time, setTime] = useState('');
    const [dose, setDose] = useState('');
    const [name, setName] = useState('');
    const [stock, setStock] = useState('');
    const [meds, setMedList] = useRecoilState(medList);
    const [days, setDays] = useState({
        monday: false,
        tuesday: false,
        wednesday: false,
        thursday: false,
        friday: false,
        saturday: false,
        sunday: false,
    });

    const [timeHour, setTimeHour] = useState({});
    const handleAdd = () => {
        console.log('handleAdd');

        const date = new Date();
        const med = {
            name,
            dose,
            stock,
            time,
            ...days,
            ...timeHour,
            id: Number(
                `${date.getFullYear()}${date.getMonth()}${date.getDate()}${date.getHours()}${date.getMinutes()}${date.getSeconds()}${date.getTime()}`
            ),
        };
        setMedList((prev) => {
            return [...prev, med];
        });
        console.log(meds);
        handleClean();
    };

    const handleClean = () => {
        console.log('handleClean');
        setTimeHour({});
        setTime('');
        setDose('');
        setName('');
        setStock('');
        setDays({
            monday: false,
            tuesday: false,
            wednesday: false,
            thursday: false,
            friday: false,
            saturday: false,
            sunday: false,
        });
    };
    useEffect(() => {
        setTimeHour({
            hour: Number(`${time[0]}${time[1]}`),
            minute: Number(`${time[3]}${time[4]}`),
        });
    }, [time, setTime]);
    const handleCheckbox = (e) => {
        const bool = e.target.checked;
        const key = e.target.closest('.checkbox').dataset.day;
        setDays((prev) => ({
            ...prev,
            [key]: bool,
        }));
    };
    return (
        <div className="dash__post">
            <input
                placeholder="Enter Med Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                className="med__input med__name"
                type="text"
            />
            <input
                placeholder="Dose (in mg)"
                value={dose}
                onChange={(e) => setDose(e.target.value)}
                className="med__input med__dose"
                type="text"
            />
            <input
                value={stock}
                placeholder="Stock"
                className="med__input med__stock"
                type="number"
                onChange={(e) => setStock(e.target.value)}
            />
            <input
                placeholder="Set Time"
                onChange={(e) => {
                    setTime(e.target.value);
                }}
                value={time}
                className="med__input med__time"
                type="time"
            />

            <div className="med__check med__days">
                <div className="checkbox" data-day="monday">
                    <p className="checkbox__label">Mon</p>
                    <input
                        onChange={handleCheckbox}
                        className="checkbox__input"
                        type="checkbox"
                    />
                </div>
                <div className="checkbox" data-day="tuesday">
                    <p className="checkbox__label">Tue</p>
                    <input
                        onChange={handleCheckbox}
                        className="checkbox__input"
                        type="checkbox"
                    />
                </div>
                <div className="checkbox" data-day="wednesday">
                    <p className="checkbox__label">Wed</p>
                    <input
                        onChange={handleCheckbox}
                        className="checkbox__input"
                        type="checkbox"
                    />
                </div>
                <div className="checkbox" data-day="thursday">
                    <p className="checkbox__label">Thur</p>
                    <input
                        onChange={handleCheckbox}
                        className="checkbox__input"
                        type="checkbox"
                    />
                </div>
                <div className="checkbox" data-day="friday">
                    <p className="checkbox__label">Fri</p>
                    <input
                        onChange={handleCheckbox}
                        className="checkbox__input"
                        type="checkbox"
                    />
                </div>
                <div className="checkbox" data-day="saturday">
                    <p className="checkbox__label">Sat</p>
                    <input
                        onChange={handleCheckbox}
                        className="checkbox__input"
                        type="checkbox"
                    />
                </div>
                <div className="checkbox" data-day="sunday">
                    <p className="checkbox__label">Sun</p>
                    <input
                        onChange={handleCheckbox}
                        className="checkbox__input"
                        type="checkbox"
                    />
                </div>
            </div>
            <div className="button__container">
                <button onClick={handleAdd} className="post__button">
                    <DoneIcon
                        style={{ width: 30, height: 30, color: '#fff' }}
                    />
                </button>
                <button onClick={handleClean} className="post__button">
                    <CancelIcon
                        style={{ width: 30, height: 30, color: '#fff' }}
                    />
                </button>
            </div>
        </div>
    );
};

export default Post;
