import { Delete, Edit } from '@mui/icons-material';
import { useRecoilValue } from 'recoil';
import { medList } from '../../Atoms/medAtom';
import './MedList.css';
const MedList = () => {
    const meds = useRecoilValue(medList);
    return (
        <div className="medlist">
            {meds.map((med, i) => (
                <div className="med__item">
                    <h1 className="med__name">Medicine: {med.name}</h1>
                    <div className="med--container">
                        <h1 className="med__time">Time: {med.time}</h1>
                        <h1 className="med__dose">Dose: {med.dose}</h1>
                    </div>
                    <div className="med--container">
                        <h1 className="med__stock"> Stock: {med.stock}</h1>
                        <h1 className="med__icons">
                            <Edit />
                            <Delete />
                        </h1>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default MedList;
