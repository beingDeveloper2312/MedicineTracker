import AddIcon from '@mui/icons-material/Add';
import CancelIcon from '@mui/icons-material/Cancel';
import DoneIcon from '@mui/icons-material/Done';
import { useRecoilState } from 'recoil';
import { medList } from '../../Atoms/medAtom';
import './Post.css';
import { useState } from 'react';
const Post = () => {
    const [time, setTime] = useState('');
    const [dose, setDose] = useState('');
    const [name, setName] = useState('');
    const [stock, setStock] = useState('');
    const [meds, setMedList] = useRecoilState(medList);

    const handleAdd = () => {
        console.log('handleAdd');
        const med = {
            name,
            dose,
            stock,
            time,
        };
        setMedList((prev) => {
            return [...prev, med];
        });
        handleClean();
    };

    const handleClean = () => {
        console.log('handleClean');
        setTime('');
        setDose('');
        setName('');
        setStock('');
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
                onChange={(e) => setTime(e.target.value)}
                value={time}
                className="med__input med__time"
                type="time"
            />
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
